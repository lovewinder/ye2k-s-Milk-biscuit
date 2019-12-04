(function () {
  var pheight = $(document).height()
  $(".main").css({
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
    "height": pheight * 0.04,
    // "line-height": pheight * 0.04
  })

  $("ul.qa").css({
    "height": pheight * 0.64
  })
})()