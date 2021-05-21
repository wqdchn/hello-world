$ cat test
The quick brown fox jumps over the lazy dog.
The quick brown fox jumps over the lazy dog.
The quick brown fox jumps over the lazy dog.
The quick brown fox jumps over the lazy dog.

$ sed -e 's/fox/cat/g ; s/dog/cat/g' test
The quick brown cat jumps over the lazy cat.
The quick brown cat jumps over the lazy cat.
The quick brown cat jumps over the lazy cat.
The quick brown cat jumps over the lazy cat.

$ cat sed_cmd.txt
s/fox/cat/g
s/dog/cat/g

$ sed -f sed_cmd.txt test
The quick brown cat jumps over the lazy cat.
The quick brown cat jumps over the lazy cat.
The quick brown cat jumps over the lazy cat.
The quick brown cat jumps over the lazy cat.

$ sed  's/\r$//g' test > new_test