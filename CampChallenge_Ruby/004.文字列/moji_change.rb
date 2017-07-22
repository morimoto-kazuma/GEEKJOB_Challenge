moji = "「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」"
s_moji = moji.gsub!(/I/,'い')
s_moji = s_moji.gsub!(/U/,'う')
print s_moji