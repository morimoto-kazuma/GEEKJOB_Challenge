#課題「メソッドの作成」で定義したメソッドを
#拡張します
#メソッドへ戻り値を追加し、trueを返却するように修正して下さい
#また、メソッドの呼び出し側で戻り値を評価しtrueなら
#「この処理は正しく実行できました。」、そうでないなら
#「正しく実行できませんでした。」と表示して下さい。

require './modori_1_sub.rb'
profile = Profile.new
check = profile.set_prof("森本佳寿馬","1990-09-09","前職は...です。")

if check == true
    puts "この処理は正しく実行できました。"
 else
    "正しく実行できませんでした。"
    end
