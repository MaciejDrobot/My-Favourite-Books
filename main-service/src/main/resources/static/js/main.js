/**
 *
 */

$('document').ready(function() {

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();

    });

    $('.table #showMapButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#mapModal #delRef').attr('href', href);
        $('#mapModal').modal();

    });

});

var map;
var myCenter=new google.maps.LatLng(12.971599, 77.594563);
var marker=new google.maps.Marker({
    position:myCenter
});

function initialize() {
    var mapProp = {
        center:myCenter,
        zoom: 14,
        draggable: false,
        scrollwheel: false,
        mapTypeId:google.maps.MapTypeId.ROADMAP
    };

    map=new google.maps.Map(document.getElementById("map-canvas"),mapProp);
    marker.setMap(map);

    google.maps.event.addListener(marker, 'click', function() {

        infowindow.setContent(contentString);
        infowindow.open(map, marker);

    });
};
google.maps.event.addDomListener(window, 'load', initialize);

google.maps.event.addDomListener(window, "resize", resizingMap());

$('#mapModal').on('show.bs.modal', function() {
    //Must wait until the render of the modal appear, thats why we use the resizeMap and NOT resizingMap!! ;-)
    resizeMap();
})

function resizeMap() {
    if(typeof map =="undefined") return;
    setTimeout( function(){resizingMap();} , 400);
}

function resizingMap() {
    if(typeof map =="undefined") return;
    var center = map.getCenter();
    google.maps.event.trigger(map, "resize");
    map.setCenter(center);
}