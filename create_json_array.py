import json
import random

numbers = [random.randint(1, 1000000) for _ in range(1000000)]

with open('/tmp/json_array.json', 'w') as f:
    json.dump(numbers, f)
