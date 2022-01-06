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
#    A         B    C  D      E    F
# 0  1  20130102  1.0  3   test  foo
# 1  2  20130102  1.0  3  train  foo
# 2  3  20130102  1.0  3   test  foo
# 3  4  20130102  1.0  3  train  foo

df_js = df.to_json(orient='records')

js = json.loads(df_js)

print(json.dumps(js))
# [{"A": "1", "B": "20130102", "C": 1.0, "D": 3, "E": "test", "F": "foo"}, {"A": "2", "B": "20130102", "C": 1.0, "D": 3, "E": "train", "F": "foo"}, {"A": "3", "B": "20130102", "C": 1.0, "D": 3, "E": "test", "F": "foo"}, {"A": "4", "B": "20130102", "C": 1.0, "D": 3, "E": "train", "F": "foo"}]

print(json.dumps(df_js))
# "[{\"A\":\"1\",\"B\":\"20130102\",\"C\":1.0,\"D\":3,\"E\":\"test\",\"F\":\"foo\"},{\"A\":\"2\",\"B\":\"20130102\",\"C\":1.0,\"D\":3,\"E\":\"train\",\"F\":\"foo\"},{\"A\":\"3\",\"B\":\"20130102\",\"C\":1.0,\"D\":3,\"E\":\"test\",\"F\":\"foo\"},{\"A\":\"4\",\"B\":\"20130102\",\"C\":1.0,\"D\":3,\"E\":\"train\",\"F\":\"foo\"}]"

for i in range(len(df)):
    print(js[i])
# {'A': '1', 'B': '20130102', 'C': 1.0, 'D': 3, 'E': 'test', 'F': 'foo'}
# {'A': '2', 'B': '20130102', 'C': 1.0, 'D': 3, 'E': 'train', 'F': 'foo'}
# {'A': '3', 'B': '20130102', 'C': 1.0, 'D': 3, 'E': 'test', 'F': 'foo'}
# {'A': '4', 'B': '20130102', 'C': 1.0, 'D': 3, 'E': 'train', 'F': 'foo'}

print(df[0:1].to_json(orient='records'))
# [{"A":"1","B":"20130102","C":1.0,"D":3,"E":"test","F":"foo"}]

print(json.dumps(df[0:1].to_json(orient='records')))
# "[{\"A\":\"1\",\"B\":\"20130102\",\"C\":1.0,\"D\":3,\"E\":\"test\",\"F\":\"foo\"}]"

print(type(json.dumps(df[0:1].to_json(orient='records'))))
