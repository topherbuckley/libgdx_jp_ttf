#!/bin/bash

sudo apt install xmlstarlet
pip install fonttools
assetPath='../android/assets/'
xmlstarlet sel -t -v "languages/language/string/@value" ${assetPath}languages.xml > text2include.txt
pyftsubset ./NotoSansJP-Black.ttf --output-file=${assetPath}jp_subset.ttf --text-file=./text2include.txt --notdef-outline
