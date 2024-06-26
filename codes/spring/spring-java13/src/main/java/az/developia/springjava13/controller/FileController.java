package az.developia.springjava13.controller;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/files")
@CrossOrigin(origins = "*")
public class FileController {

	@Autowired
	private ResourceLoader resourceLoader;

	// upload
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//Consumes    API JSON yox artiq file qebul etdiyini gosterir
	public void upload(@RequestParam(name = "file") MultipartFile file) throws Exception {

		// Get stream from file
		InputStream stream = file.getInputStream();

		// Get file original name
		// Saleh.png
		String originalFilename = file.getOriginalFilename();

		// Create random name
		UUID uuid = UUID.randomUUID();
		String randomName = uuid.toString(); // rewrwerwerwe-rwerwerwerwer

		// Get file original name without extension
		String fileNameWithoutExtension = originalFilename.substring(0, originalFilename.lastIndexOf('.'));

		// File random name for saving on disk
		String fileRandomName = originalFilename.replace(fileNameWithoutExtension, randomName);

		// Checking file
		File folder = new File("C:/java13");
		if (!folder.exists()) {
			folder.mkdir();
		}

		// Save file to disk
		Files.copy(stream, Paths.get("C:/java13" + "/" + fileRandomName), StandardCopyOption.REPLACE_EXISTING);

	}

	// full download

	// video download

	// React download
	@GetMapping(path = "/video/{title}", produces = { "video/mp4" })
//	 Return video as resource 
//	@PreAuthorize(value="hasAuthority('ROLE_LOGIN')")
	public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader String range) {
		System.out.println("Video range : " + range);

		return getVideo(title);

	}

	public Mono<Resource> getVideo(String title) {

		return Mono.fromSupplier(() -> resourceLoader.getResource("file:C:/java13/" + title));

	}

	@GetMapping("/download/{filename:.+}")
	@ResponseBody
	// @PreAuthorize(value = "hasAuthority('ROLE_LOGIN')")
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws Exception {

		Resource file = loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
				.body(file);
	}

	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Path load(String filename) {
		Path rootLocation = Paths.get("C:/java13");
		return rootLocation.resolve(filename);
	}

}