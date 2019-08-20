function insertValue()
{
    var select = document.getElementById("station");
    var i;
    var stations = ["Nairobi", "Mombasa", "Kisumu", "Nakuru", "Thika", "Limuru", "Eldoret", "Nakuru",
        "Limuru", "Nyeri", "Meru"];
    for (i = 0; i < stations.length; i++) {

        newOption = document.createElement("OPTION");
        var newOptionVal = document.createTextNode(stations[i]);
        newOption.appendChild(newOptionVal);
        select.add(newOption);
    }

    var select = document.getElementById("department");
    var i;
    var stations = ["ICT", "TV", "Radio", "Journalism", "Camera"];
    for (i = 0; i < stations.length; i++) {

        newOption = document.createElement("OPTION");
        var newOptionVal = document.createTextNode(stations[i]);
        newOption.appendChild(newOptionVal);
        select.add(newOption);





    }
    var select = document.getElementById("university");
    var i;
    var stations = ["UON", "Kenyatta", "Egerton", "JKUAT", "TUK", "Moi", "Eldoret", "TUM", "Maasai Mara", "Others"];
    for (i = 0; i < stations.length; i++) {

        newOption = document.createElement("OPTION");
        var newOptionVal = document.createTextNode(stations[i]);
        newOption.appendChild(newOptionVal);
        select.add(newOption);





    }
    var select = document.getElementById("course");
    var i;
    var stations = ["IT", "Journalism", "Computer Science", "Mass Communications", "BBIT", "Engineering"];
    for (i = 0; i < stations.length; i++) {

        newOption = document.createElement("OPTION");
        var newOptionVal = document.createTextNode(stations[i]);
        newOption.appendChild(newOptionVal);
        select.add(newOption);





    }
}