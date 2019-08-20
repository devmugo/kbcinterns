/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validatec() {



    if (document.myform.password.value != document.myform.password2.value) {
        document.getElementById('passerror').innerHTML = '';
        document.myform.password.focus();
        document.getElementById('passerror').innerHTML = 'Password do not match . Try again';
        return false;
    }

    return(true);
}

var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function () {
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.maxHeight) {
            panel.style.maxHeight = null;
        } else {
            panel.style.maxHeight = panel.scrollHeight + "px";
        }
    });
}



