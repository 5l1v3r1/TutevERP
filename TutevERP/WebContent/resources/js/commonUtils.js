var	timerID = null;
var	timerRunning = false;
var	startDate;
var	startSecs;
var common = {};

common.stopClock = function(){
	if(timerRunning)
		clearTimeout(timerID);
	timerRunning = false;
};

common.logout = function(url){
	window.location = url + "/login.xhtml";
}

common.startClock = function(){
	startDate = new Date();
	startSecs = (startDate.getHours()*60*60) + (startDate.getMinutes()*60) + startDate.getSeconds();
	common.stopClock();
	common.showTime();

};
common.firmaFiltreTemizle = function(){
	try {
		firmaBolgeTable.clearFilters();
		firmaBolumTable.clearFilters();
		firmaBolumKontakTable.clearFilters();
		envanterTable.clearFilters();
	} catch (e) {
		
	}
}


common.showTime = function (){
	var now = new Date();
	var nowSecs = (now.getHours()*60*60) + (now.getMinutes()*60) + now.getSeconds();
	var elapsedSecs = nowSecs - startSecs;

	var hours = Math.floor( elapsedSecs / 3600 );
	elapsedSecs = elapsedSecs - (hours*3600);

	var minutes = Math.floor( elapsedSecs / 60 );
	elapsedSecs = elapsedSecs - (minutes*60);

	var seconds = elapsedSecs;

	var timeValue = "" + hours;
	timeValue  += ((minutes < 10) ? ":0" : ":") + minutes;
	timeValue  += ((seconds < 10) ? ":0" : ":") + seconds;

	$(PrimeFaces.escapeClientId('form:acilisSuresi')).val(timeValue); 
	$('#form\\:acilisSuresi').val(timeValue); 
	timerID = setTimeout("common.showTime()",1000);
	timerRunning = true;
};

PrimeFaces.locales['tr'] = {
        closeText: 'kapat',
        prevText: 'geri',
        nextText: 'ileri',
        currentText: 'bugün',
        monthNames: ['Ocak','Şubat','Mart','Nisan','Mayıs','Haziran','Temmuz','Ağustos','Eylül','Ekim','Kasım','Aralık'],
        monthNamesShort: ['Oca','Şub','Mar','Nis','May','Haz', 'Tem','Ağu','Eyl','Eki','Kas','Ara'],
        dayNames: ['Pazar','Pazartesi','Salı','Çarşamba','Perşembe','Cuma','Cumartesi'],
        dayNamesShort: ['Pz','Pt','Sa','Ça','Pe','Cu','Ct'],
        dayNamesMin: ['Pz','Pt','Sa','Ça','Pe','Cu','Ct'],
        weekHeader: 'Hf',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        timeOnlyTitle: 'Zaman Seçiniz',
        timeText: 'Zaman',
        hourText: 'Saat',
        minuteText: 'Dakika',
        secondText: 'Saniye',
        ampm: false,
        month: 'Ay',
        week: 'Hafta',
        day: 'Gün',
        allDayText : 'Tüm Gün'
    };


