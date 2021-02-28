awk '{for (i = 1; i <= NF ; i++) if (length($i) < 8) print $i}' txt/data.txt

awk '{a+=$6}END{print a}' txt/ps.txt

awk '{for ( i = 1; i <= NF; i++ ) { arry[$i]++ }} END {for ( key in arry ){ print key" "arry[key] }}' txt/data.txt

awk '{for (i = 1; i <= NF ; i++)  print $i}' txt/data.txt

awk '{print $2}' txt/data.txt | sort | uniq -cd | sort

