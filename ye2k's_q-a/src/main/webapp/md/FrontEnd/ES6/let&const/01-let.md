#### 1 基本用法

* 用于声明变量,用法类似于var,但是声明的变量只在let命令所在的**代码块**内有效.


* for循环的计数器很适合使用let命令

  ```
  for(let i = 0; i < 10; i++){
    // ...
  }
  ```


* ```
      var a = []
      for (var i = 0; i < 10; i++) {
        a[i] = function () {
          console.log(i)
        }
      }

      a[6]() // 10
  ```

  ```
      var a = []
      for (let i = 0; i < 10; i++) {
        a[i] = function () {
          console.log(i)
        }
      }

      a[6]() // 6
  ```


* note: for循环设置循环变量的那部分是一个父作用域,而循环体内部是一个单独的子作用域



#### 2 不存在变量提升

* let声明的变量一定要在生命后使用,否则会报错

  ```
  console.log(foo) // undefined
  var foo = 2

  console.log(bar) // 报错ReferenceError
  let bar = 2
  ```

  ​

#### 3 暂时性死区

* 只要块级作用域内存在命令,它所声明的变量就"绑定"这个区域,不再受外部影响

  ```
  var tmp = 123
  if(true){
    tmp = "abc" // ReferenceError
    let tmp;
  }
  ```


* 在代码块内,使用let声明变量之前,该变量都是不可用的,这在语法上成为"暂时性死区"(temporal dead zone,简称TDZ)

  ```
  if(true){
    // TDZ开始
    tmp = "abc" // ReferenceError
    console.log(tmp) // ReferenceError
    
    let tmp // TDZ结束
    console.log(tmp) // undefined
    
    tmp = 123
    console.log(tmp) // 123
  }
  ```


* 暂时性死区意味着typeof不再是一个百分百安全的操作

  ```
  typeof x // ReferenceError
  let x
  ```

* 有些死区比较隐蔽

  ```
  function bar(x = y, y = 2){
    return [x, y]
  }

  bar() // 报错
  ```

  * 参数x的默认值等于另一个参数y,而此时y还没有声明,属于死区


* ```
  var x = x // 不报错

  let x = x // 报错
  ```

  ​

#### 4 不允许重复声明

* let不允许在相同作用域内声明同一个变量

  ```
  // 报错
  function(){
    let a = 10
    var a = 1
  }

  // 报错
  function(){
    let a = 10
    let a = 1
  }

  // 不能在函数内部重新声明参数
  function func(arg){
    let arg // 报错
  }

  function func(arg){
  	{
  	  let arg // 不报错
  	}
  }
  ```

  ​