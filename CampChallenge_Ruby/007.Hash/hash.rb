hako = Hash.new
hako["1"] = "AAA"
hako["hello"] = "world"
hako["soeda"] = "33"
hako["20"] = "20"

if hako.key?("1")
hako.each do |key,value|
    puts "キーに#{key}、要素は#{value}です"
    end
end