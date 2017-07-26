require './class_mesoddo.rb'
profile = Profile.new

name = "森本"
birth = "1990-09-09"
pro = "前職は...です。"

10.times do
    profile.set_prof(name,birth,pro)
    end