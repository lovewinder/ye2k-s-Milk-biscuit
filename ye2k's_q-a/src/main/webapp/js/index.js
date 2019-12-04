(function () {
  $(".answer-btn").on("click", function () {
    $(".answer").show()
  })

  $(".ican-btn").on("click", function () {
    console.log("ican");
    // 存到ican中
  })

  $(".icant-btn").on("click", function () {
    console.log("icant");
    // 存到icant中
  })

  $("ul").on("click", ".lu-question", function () {
    console.log(this);
    var index = $(this).parent().index();
    console.log(index);
    // console.log($(".lu-answer").parent().eq(index).children(".lu-answer")[0]);
    // $(".lu-answer").parent().eq(index).siblings().children(".lu-answer").slideUp()
    // $(".lu-answer").parent().eq(index).children(".lu-answer").slideToggle()
    // $(".lu-answer").parent().eq(index).children(".lu-answer").show()
    $(this).parent().siblings().children(".lu-answer").slideUp()
    $(this).next().slideToggle()
    $(this).next().show()
  })

  
})()