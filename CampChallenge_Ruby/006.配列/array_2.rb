hako = Array.new(2)
hako.unshift("10")
hako.push("hayashi")
hako[1,2] = ["100","soeda"]
hako.concat(["-20","118","END"])
hako.each_with_index do |hako2|
    puts "要素は#{hako2}です"
    end