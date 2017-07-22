check = ""
check = check.eql?("AAA") ? "5" : "10"
check = "あ" if check.to_i > 6

case check
  when "A"
    puts "英語"
  when "あ"
    puts "日本語"
end
