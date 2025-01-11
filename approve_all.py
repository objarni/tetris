import os


def rename_files_recursively(directory='.'):
    # Iterate over all items in the directory
    for item in os.listdir(directory):
        item_path = os.path.join(directory, item)

        # If the item is a directory, recurse into it
        if os.path.isdir(item_path):
            rename_files_recursively(item_path)
        # If the item is a file that matches the pattern, rename it
        elif item.endswith('.received.txt'):
            new_name = os.path.join(directory, item.replace('.received.txt', '.approved.txt'))
            os.rename(item_path, new_name)
            print(f'Renamed: {item_path} -> {new_name}')

if __name__ == "__main__":
    rename_files_recursively()

