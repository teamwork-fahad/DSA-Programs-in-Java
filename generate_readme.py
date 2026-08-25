import os
from datetime import datetime

ROOT = os.path.dirname(os.path.abspath(__file__))
IGNORE = {".git", ".github", "__pycache__", ".vscode"}

topics = []
for folder in sorted(os.listdir(ROOT)):
    path = os.path.join(ROOT, folder)
    if not os.path.isdir(path) or folder in IGNORE:
        continue
    files = sorted(file for file in os.listdir(path)
                   if file.endswith(".java") and os.path.isfile(os.path.join(path, file)))
    if files:
        topics.append((folder, files))

lines = [
    "# DSA Programs in Java",
    "",
    "A collection of Data Structures and Algorithms programs written in Java.",
    "",
    "## How to Run",
    "",
    "From a topic directory, compile and run any program:",
    "",
    "```bash",
    "javac FactorialRecursive.java",
    "java FactorialRecursive",
    "```",
    "",
    "Run `python generate_readme.py` from this directory to refresh the program index.",
    "",
    "## Repository Statistics",
    "",
    f"- **Total Topics:** {len(topics)}",
    f"- **Total Programs:** {sum(len(files) for _, files in topics)}",
    "",
    "## Index",
    "",
]

for folder, _ in topics:
    lines.append(f"- [{folder}](#{folder.lower().replace(' ', '-')})")

for folder, files in topics:
    lines.extend(["", f"## {folder}", "", "| No. | Program |", "|:---:|---------|"])
    for index, file in enumerate(files, start=1):
        title = os.path.splitext(file)[0].replace("-", " ").replace("_", " ")
        lines.append(f"| {index} | [{title}](./{folder}/{file}) |")

lines.extend(["", "---", "", f"**Last Updated:** {datetime.now():%d %B %Y %I:%M %p}", ""])
with open(os.path.join(ROOT, "README.md"), "w", encoding="utf-8") as readme:
    readme.write("\n".join(lines))
print("README.md generated successfully.")
