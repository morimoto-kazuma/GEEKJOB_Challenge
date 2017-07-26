#1. ３つの引数を持ち、渡された数値で掛け算をするメソッドを
#作成します。
#メソッドは、１つ目の引数と２つ目の引数を掛け算し、
#３つ目の引数がtrue(Trueオブジェクト)の場合は結果を
#２乗させてください。
#また、２つ目の引数は5、
#３つ目の引数はfalse(Falseオブジェクト)を
#初期値として設定してください。
#2. 作成したメソッドを呼び出し、結果を表示してください。

class Calculation

    def vales(num1 = 5,num2=5,check=false)
     
        i = num1 * num2
        if check == true
            i = i * i
            end
            puts i
      
        end
    end

