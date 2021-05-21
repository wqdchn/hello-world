import json
import pandas as pd
import numpy as np

df = pd.DataFrame({'A': pd.Series(['1', '2', '3', '4']),
                   'B': pd.Series(['20130102', '20130102', '20130102', '20130102']),
                   'C': pd.Series(1, index=list(range(4)), dtype='float32'),
                   'D': np.array([3] * 4, dtype='int32'),
                   'E': pd.Categorical(["test", "train", "test", "train"]),
                   'F': 'foo'})

print(df)

df_js = df.to_json(orient='records')

js = json.loads(df_js)

for i in range(len(df)):
    print(js[i])
