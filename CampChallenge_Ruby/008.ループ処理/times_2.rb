#文字連結"A"が30個入った状態。
name = ["森本"]
num = "123456789"
moji = "A"

30.times do
name.push(moji)
end
name.push(num)
puts name