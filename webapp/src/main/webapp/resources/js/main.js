function changeRouteType() {

    let table = document.getElementById('timetable');
    let stationName = document.getElementById('station');
    let regPhrase = new RegExp(stationName.innerText, 'i');
    let flag = false;

    let departure = true;
    let routeTypes = document.getElementsByName('route');
    if (routeTypes[1].checked) departure = false;

    for (let i = 1; i < table.rows.length; i++) {
        flag = false;
        if (departure) {
            flag = regPhrase.test(table.rows[i].cells[2].innerHTML);
        } else {
            flag = regPhrase.test(table.rows[i].cells[4].innerHTML);
        }
        if (flag) {
            table.rows[i].style.display = "";
        } else {
            table.rows[i].style.display = "none";
        }
    }

}

function onTimetableUpdate(message, channelName, event) {
    document.location.reload();
}