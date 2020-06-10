# Flesch Reading Ease Score

### What it is
Simple program that calculates (more or less) the [Flesch Reading Ease Score](https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests) for a given text, depending on your definition of an English [sentence](https://www.jstor.org/stable/412257 ) and [syllable](https://books.google.com/books?hl=en&lr=&id=Ev0WCgAAQBAJ&oi=fnd&pg=PP1&dq=English+syllable&ots=qQ0hFbmpgf&sig=V-lnXa1KThvyucldZe2CLGI7CII#v=onepage&q=English%20syllable&f=false).

### Use
```
make test

# Flesch Reading Ease Score is 66.4
# Flesch-Kincaid Score is 5.24

java Main txt/seuss.txt

# Flesch Reading Ease Score is 101.81
# Flesch-Kincaid Score is 0.5

java Main txt/brain.txt

# Flesch Reading Ease Score is 21.22
# Flesch-Kincaid Score is 15.51
```

### What it isn't
Terribly interesting.
