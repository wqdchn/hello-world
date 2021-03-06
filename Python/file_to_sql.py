import pandas as pd
import os

converter = {x:str for x in pd.read_excel(os.getcwd() + '/data/data.xlsx','Sheet1').columns}

df = pd.read_excel(os.getcwd() + '/data/data.xlsx', 'Sheet1', converters=converter)

table_nm = '表名'

sql_texts = []
for index, row in df.iterrows():

    if index == 0:
        sql_texts.append(
            'INSERT INTO ' + table_nm + ' (' + str(','.join(df.columns)) + ')  VALUES ' + str(
                tuple(str(row.values).replace('\'', '').strip('[').strip(']').split(' '))))
    else:
        sql_texts.append(str(tuple(str(row.values).replace('\'', '').strip('[').strip(']').split(' '))))

print(','.join(sql_texts))

f = open(os.getcwd() + '/data/sql.txt','w')
f.writelines(','.join(sql_texts))