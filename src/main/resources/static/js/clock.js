function time() {
    var today = new Date();
    var weekday = new Array(7);
    weekday[0] = "Chủ nhật";
    weekday[1] = "Thứ hai";
    weekday[2] = "Thứ ba";
    weekday[3] = "Thứ tư";
    weekday[4] = "Thứ năm";
    weekday[5] = "Thứ sáu";
    weekday[6] = "Thứ bảy";

    var day = weekday[today.getDay()];
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var year = today.getFullYear();
    var hour = today.getHours();
    var minute = today.getMinutes();
    var second = today.getSeconds();
    minute = checkTime(minute);
    second = checkTime(second);
    now = hour + " giờ " + minute + " phút " + second + " giây ";
    if(dd < 10){
        dd = '0' + dd;
    }

    if(mm < 10){
        mm = '0' + mm;
    }

    today = day + ", " + dd + '/' + mm + '/' + year;
    tmp = '<span class="date">' + today + ' - ' + now + '</span>';
    document.getElementById("clock").innerHTML = tmp;
    clocktime = setTimeout("time()", "1000", "Javascript");

    function checkTime(i){
        if(i < 10){
            i = "0" + i;
        }
        return i;
    }

}


