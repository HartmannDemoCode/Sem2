
var bluebox = document.getElementById("bluebox");
//var myFunction2 = function(){
//    temp2 = "Hello from 2";
//};
//var temp1;
//var temp2;
//myFunction1();
//myFunction2();
//console.log(temp1);
//console.log(temp2);
//
//
bluebox.onclick = function () {
    
    if (this.style.border === "2px solid red")
        this.style.border = "2px solid blue";
    else
        this.style.border = "2px solid red";


};
//function myFunction1(){
//    temp1 = "Hello from 1";
//}

/*var secondlevel = 10;
 function myFunc(){
 var firstlevel = 100;
 (function nestedFunc(){
 var sencondlevel = 20;
 console.log(firstlevel); //prints 100
 
 })();
 console.log(secondlevel); //prints 10
 }
 myFunc();
 
 persons = [{
 "name" : "Hans",
 "age": 17,
 getName: function(){
 var nameAndAge = this.name +" "+this.age;
 return nameAndAge;
 }
 },
 {
 "name" : "Hans",
 "age": 17,
 getName: function(){
 var fullname = name + age;
 return fullname;
 }
 }];
 
 classroom = {
 "students": persons,
 getStudents: function(){
 return this.students;
 }
 };
 console.log(classroom.getStudents()[0].getName());
 console.log(nameAndAge);
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 */