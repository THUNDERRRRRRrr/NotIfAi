import os
import re

def remove_comments_from_file(filepath):
    with open(filepath, 'r') as f:
        content = f.read()

    # Regex to match strings or comments
    pattern = re.compile(
        r'(?s)(".*?"|\'.*?\')|(/\*.*?\*/|//[^\r\n]*)'
    )

    def replacer(match):
        if match.group(2) is not None:
            return '' # It's a comment
        else:
            return match.group(1) # It's a string
            
    new_content = pattern.sub(replacer, content)
    
    # Remove multiple consecutive blank lines
    new_content = re.sub(r'\n\s*\n', '\n\n', new_content)

    with open(filepath, 'w') as f:
        f.write(new_content)

def main():
    for root, dirs, files in os.walk('/home/GentooBtw/NotIfAi/app/src'):
        for file in files:
            if file.endswith('.kt') or file.endswith('.java') or file.endswith('.kts'):
                filepath = os.path.join(root, file)
                remove_comments_from_file(filepath)
    print("Comments removed successfully.")

if __name__ == '__main__':
    main()
