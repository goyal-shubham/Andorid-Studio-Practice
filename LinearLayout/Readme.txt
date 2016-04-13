This project has been done while working with the LinearLayout in Horizontal mode. Things learned :
1. If we use match_parent, then the first child will cover the whole horizontal Space remaning after that child.
2. If we give every child as weight = 1 and width = wrap_content, then the distribution is not equal among all the childs.
    Rather, it is on based of the content of text.
3. To get uniform distribution horizontally, we need to give the width = 0dp.
4. Checked different attribute like padding, margins , gravity and weights in the layout.