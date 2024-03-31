function loadStudents(event){

    // bu obyekti apiye gonder
    var xml=new XMLHttpRequest();

    xml.onload=function(){
        var massiv= JSON.parse(this.responseText);
        massiv.students.forEach(s => {
            document.getElementById('students').innerHTML+="<tr><td>"+s.id+"</td><td>"+s.name+"</td><td>"+s.surname+"</td></tr>";
        });
    };

    xml.open('GET','http://localhost:8080/students',true);

    xml.send();
}

loadStudents();