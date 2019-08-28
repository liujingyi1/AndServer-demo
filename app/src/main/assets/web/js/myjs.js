$(document).ready(function(){

    $('#myTabs a').click(function (e) {
//      alert($(e.target).attr("href"));
//      $($(e.target).attr("href")).load("device.html")
//      $(e.target).load("device.html");
      e.preventDefault()
      $(this).tab('show')
    })

    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
//        alert(e.target)
//        alert(e.relatedTarget)

//        $(e.relatedTarget).load("device.html");

      e.target // newly activated tab
      e.relatedTarget // previous active tab
    })

});