import os
import re
import sys


def parse_problem_info(file_name):
    file_splits = file_name.split('/')
    problem_type = 'PRGMS' if file_splits[0] == '프로그래머스' else 'BOJ'
    problem_number = file_splits[2].split('.')[0]
    problem_name = file_splits[2].split('.')[1].strip()
    language = file_splits[3].split('.')[1].strip()
    return [problem_type, problem_number, problem_name, language]


if len(sys.argv) != 3 or not re.search('(?:/[^/]+){3}/?', sys.argv[1]):
    print("please check script input")
    exit(0)

target_problem_file_name = sys.argv[1]
script_dir = os.path.dirname(os.path.abspath(__file__))
read_file_path = os.path.join(script_dir, sys.argv[2])

start_week_pattern = re.compile('<td>(\d+)주차</td>')

readme_file = open(read_file_path, 'r')

problems_by_week = {}
is_week_start = False
week_number = 0
for line in readme_file:
    if start_week_pattern.search(line):
        is_week_start = True
        week_number = start_week_pattern.findall(line)[0]
        problems_by_week[week_number] = []
        continue

    if "</tr>" in line:
        is_week_start = False
        continue

    if is_week_start:
        problem_number_candidates = re.findall('/(\d+)"', line)
        if len(problem_number_candidates) == 0:
            continue

        problem_number = problem_number_candidates[0]
        if "programmers" in line:
            problems_by_week[week_number].append('PRGMS ' + problem_number)
        elif "acmicpc" in line:
            problems_by_week[week_number].append('BOJ ' + problem_number)

target_problem_info = parse_problem_info(target_problem_file_name)
for key in problems_by_week:
    if target_problem_info[0]+ ' ' + target_problem_info[1] in problems_by_week[key]:
        result_file = open(os.path.join(script_dir, "result.txt"), 'w')
        result = f"WEEK_NUMBER={key}\n" \
                 f"TYPE={target_problem_info[0]}\n" \
                 f"PROBLEM_NUMBER={target_problem_info[1]}\n" \
                 f"PROBLEM_NAME={target_problem_info[2]}\n" \
                 f"SOLVED_LANGUAGE={target_problem_info[3]}\n"
        result_file.write(result)
