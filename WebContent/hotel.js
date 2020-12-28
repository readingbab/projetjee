var tbody = document.querySelector('#example tbody');
var firstTr = tbody.firstElementChild;
var childTr = firstTr;
var myArray = new Array();
var lastTd = childTr.lastElementChild;
var childTd = childTr.firstElementChild;
var inputs = new Array();
var ville;
while (childTr) {
    myArray = new Array();
    lastTd = childTr.lastElementChild;
    childTd = childTr.firstElementChild;
    while (childTd && childTd != lastTd) {
        myArray.push(childTd.textContent);
        childTd = childTd.nextElementSibling;
    }
    inputs = new Array();
    inputs = lastTd.querySelectorAll('.modalito input');
    for (var i = 0, c = inputs.length; i <3; i++) {
        inputs[i].value = myArray[i+3];
        
    }
    
    childTr = childTr.nextElementSibling;
}