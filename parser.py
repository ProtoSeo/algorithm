import os
import re

script_dir = os.path.dirname(os.path.abspath(__file__))
relative_path = "algorithm-study/README.md"
file_path = os.path.join(script_dir, relative_path)

start_week_pattern = re.compile('<td>(\d+)주차</td>')
problem_number_pattern = re.compile('/(\d+)"')

file = open(file_path, 'r')
result = open(os.path.join(script_dir, "result.txt"), 'w')
str_list = []
for line in file:
    str_list.append(line.strip())

for i in range(0, len(str_list)):
    line = str_list[i]
    if not start_week_pattern.search(line):
        continue

    week_number = start_week_pattern.findall(line)[0]
    result.write(week_number + '주차' + '\n')
    i += 1
    next_line = str_list[i]
    while "</tr>" not in next_line:
        problem_number = problem_number_pattern.findall(next_line)[0]
        if "programmers" in next_line:
            result.write('PRGMS ' + problem_number + '\n')
        elif "acmicpc" in next_line:
            result.write('BOJ ' + problem_number + '\n')
        i += 1
        next_line = str_list[i]
    result.write('\n')
