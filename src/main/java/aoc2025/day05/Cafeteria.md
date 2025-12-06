## --- Day 5: Cafeteria ---

As the forklifts break through the wall, the Elves are delighted to discover that there was a cafeteria on the other side after all.

You can hear a commotion coming from the kitchen.  
"At this rate, we won't have any time left to put the wreaths up in the dining hall!"  
Resolute in your quest, you investigate.

"If only we hadn't switched to the new inventory management system right before Christmas!" another Elf exclaims.  
You ask what's going on.

The Elves in the kitchen explain the situation: because of their complicated new inventory management system, they can't figure out which of their ingredients are **fresh** and which are **spoiled**. When you ask how it works, they give you a copy of their database (your puzzle input).

The database operates on **ingredient IDs**.  
It consists of:

- a list of **fresh ingredient ID ranges**
- a blank line
- a list of **available ingredient IDs**

For example:

```
3-5
10-14
16-20
12-18

1
5
8
11
17
32
```

The fresh ID ranges are **inclusive**:  
The range `3-5` means IDs `3`, `4`, and `5` are all *fresh*.

Ranges can also **overlap**.  
An ingredient ID is considered fresh if it is inside **any** range.

### Example reasoning

- ID `1` is spoiled (not in any range).
- ID `5` is fresh (in `3-5`).
- ID `8` is spoiled.
- ID `11` is fresh (in `10-14`).
- ID `17` is fresh (in `16-20` and `12-18`).
- ID `32` is spoiled.

In this example, **3** of the available ingredient IDs are fresh.

Process your input database.  
**How many of the available ingredient IDs are fresh?**