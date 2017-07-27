#引数が１つのメソッドを作成してください。
#メソッドの中の処理は、
#３人分のプロフィール（項目は戻り値2と同様）を作成し、
#引数として渡された値と同じIDを持つ人物のプロフィールを
#返却する様にしてください。
#それ以降は課題「戻り値2」と同じ処理にしてください。

class Back

    def profile(id)
    
    prof0 = [1,"森本","0909","大阪"]
    prof1 = [2,"田中","0101","江戸"]
    prof2 = [3,"山田","0202","アメリカ"]
    
      case id #idが1、2、3でそれぞれのプロフィールを返却する
        when prof0[0] #1
         return prof0
        when prof1[0] #2
         return prof1
        when prof2[0] #3
         return prof2
      end
    
    end

end
