function loadTeachers(event){

    // bu obyekti apiye gonder
    let xml=new XMLHttpRequest();

    xml.onload=function(){
        let massiv= JSON.parse(this.responseText);
        massiv.teachers.forEach(s => {
            document.getElementById('teachers').innerHTML+="<tr><td>"+s.id+"</td><td>"+s.name+"</td><td>"+s.surname+"</td></tr>";
        });
    }

    xml.open('GET','http://localhost:8080/teachers',true);

    xml.send();
}

loadTeachers();