(function () {
  var pheight = $(document).height()
  $(".answer-main").css({
    "height": pheight * 1,
    // "margin-top": pheight * 0.05,
    // "margin-bottom": pheight * 0.05
  })

  $(".look-up-main").css({
    "height": pheight * 1,
    // "margin-top": pheight * 0.05,
    // "margin-bottom": pheight * 0.05
  })

  $(".title").css({
    "height": pheight * 0.05,
    // "line-height": pheight * 0.04
  })

  $("ul.qa").css({
    "height": pheight - $("#dropdownMenu1").outerHeight(),
    "top": $("#dropdownMenu1").outerHeight(),
  })

  $(".swiper-container").css({
    "height": pheight
  })

  $(".changePage").css({
    "height": pheight
  })

  $(".aslid-mbd").css({
    "height": pheight
  })

  $(".main-mbd").css({
    "height": pheight
  })

  $(".main-mbd-ul .show").css({
    "height": pheight
  })

  $("#article").css({
    "height": pheight
  })
})()