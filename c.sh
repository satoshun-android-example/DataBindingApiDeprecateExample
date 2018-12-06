src="app/src/main/res/layout/main_act99.xml"
dst="base/src/main/res/layout/module"

for i in {2..100}
do
    cp $src $dst$i.xml
done
