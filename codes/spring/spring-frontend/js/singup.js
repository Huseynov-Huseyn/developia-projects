function onSaveTeacher(event){
    event.preventDefault();

    // inputlardan datalari string olaraq gotur
    let teacherName=document.getElementById('teacher-name').value;
    let teacherSurname=document.getElementById('teacher-surname').value;
    let teacherUsername=document.getElementById('teacher-username').value;
    let teacherPassword=document.getElementById('teacher-password').value;
    let teacherEmail=document.getElementById('teacher-email').value;
    
    let teacherObject={};
    teacherObject.name=teacherName;
    teacherObject.surname=teacherSurname;
    teacherObject.username=teacherUsername;
    teacherObject.password=teacherPassword;
    teacherObject.email=teacherEmail;

     // bu melumatlari js obyekti halina sal
    let request=JSON.stringify(teacherObject);

    // bu obyekti apiye gonder
    let xml=new XMLHttpRequest();
    xml.open('POST','http://localhost:8080/users/teacher',true);
    xml.setRequestHeader('Content-type','application/json');
    xml.send(request);
}