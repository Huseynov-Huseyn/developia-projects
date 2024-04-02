function loadStudents(){

    // bu obyekti apiye gonder
    let xml=new XMLHttpRequest();

    xml.onload=function(){
        let massiv= JSON.parse(this.responseText);
        massiv.students.forEach(s => {
            document.getElementById('students').innerHTML+="<tr><td>"+s.id+"</td><td>"+s.name+"</td><td>"+s.surname+"</td></tr>";
        });
    };

    xml.open('GET','http://localhost:8080/students',true);
    
    xml.send();
}
loadStudents();