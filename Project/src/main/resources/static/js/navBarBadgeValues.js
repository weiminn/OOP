$('#favbadge').text(JSON.parse(localStorage.getItem("noOfFavAdded")).length);

$('#subbadge').text(JSON.parse(localStorage.getItem("noOfSubAdded")).length);
        
// Show or hide badge based on value
if($('#favbadge').text() <= 0){
    $('#favbadge').hide();
}else{
    $('#favbadge').show();
}

// Show or hide badge based on value
if($('#subbadge').text() <= 0){
    $('#subbadge').hide();
}else{
    $('#subbadge').show();
}