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
    for (var i = 0, c = inputs.length; i <6; i++) {
        inputs[i].value = myArray[i+1];
        
    }
    optionVille = lastTd.querySelector('.modalito .used').options;
    for (var i = 0, c = optionVille.length; i < c; i++) {
        if (optionVille[i].value == myArray[7]){
            optionVille[i].selected = 'selected';
        }
    }
    optionVille = lastTd.querySelector('.modalito .newSel').options;
    for (var i = 0, c = optionVille.length; i < c; i++) {
        if (optionVille[i].value == myArray[8]) {
            optionVille[i].selected = 'selected';
        }
    }
    console.log(myArray[8]);
    childTr = childTr.nextElementSibling;
}