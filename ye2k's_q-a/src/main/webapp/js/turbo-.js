// 封装重复代码 (动画)
// 参数：
//  element：做动画的元素(dom对象)
//  target： 动画的目标值（终点值）
//  num: 每次移动的距离
function animate(element, target, num) {
    
    // num参数的效果
    // 如果num传递了50，num取50
    // 如果num没有传递参数， num默认取60
    num = num || 60;


    // 函数内的代码执行之前，先要预解析(声明提升)
    // var timerId; // undefined

    clearInterval(element.timerId);
    // console.log("上一次的timerId ", timerId);

    // 开之前，先把上一次开启的定时器给清除掉
    // dom对象.属性 = 定时器的id ==> 和存储下标一回事。 lis[i].index = i;
    element.timerId = setInterval(function() {
        // 1. 获取元素当前位置
        var current = element.offsetLeft;

        var step = current < target ? num : -num; // 每次移动的距离
        // console.log("step的值 ", step);

        if (Math.abs(target - current) < Math.abs(step)) {
            // 到终点了 ==> 清除定时器
            clearInterval(element.timerId);

            // 清除定时器的时候，元素不一定真的到了终点
            // 没有到达终点，直接去终点
            element.style.left = target + "px";
        } else {
            // 没有到终点
            // 2. 在当前位置上移动一段距离
            current += step;

            // 3. 
            element.style.left = current + "px";
        }
    }, 15)
}
