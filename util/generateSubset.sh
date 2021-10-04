#!/bin/bash

pip install fonttools
assetPath='../android/assets/'
pyftsubset ${assetPath}NotoSansJP-Black.ttf --output-file=${assetPath}jp_subset.ttf --text-file=${assetPath}text2include.txt --notdef-outline