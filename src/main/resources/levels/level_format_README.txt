here is the definition for the level format and the meaning of each value

    0 is empty bloc (aka grass)
    1 is breakable bloc
    2 is pushable bloc
    3 is trap bloc
    4 is invincible bloc
    5 is an appear/disappear bloc
    6 is treadmill bloc
    7 is ball
    8 is snoopy
    9 is a bird

these blocks need more than a single value, as they have 4 or 2 direction
4 direction :   ball(SO, SE, NO, NE),
                treadmill(NORTH, SOUTH, WEST, EAST),
                snoopy(NORTH, SOUTH, WEST, EAST),
                pushable block(NORTH, SOUTH, WEST, EAST)

2 directino :   bird(EAST, WEST)
---
in addition, we have the following blocks that can have more than one state :
pushable block : we need to know if the block was already pushed or not, and in what direction it is possible to push it

NOT concerned
breakable bloc : is not concerned, because when broken it becomes an empty bloc which has only one state
trap block : since it will only activate once, and become a empty bloc, it is not concerned
----

So we have 10 types of blocks, of which 3 have 4 states, 1 has 8 state, 1 has 2 states, and 5 have only one state :
empty bloc              : 1 state
breakable bloc          : 1 state
pushable bloc           : 8 states
trap bloc               : 1 state
invincible bloc         : 1 state
appear/disappear bloc   : 1 state//or 2
ball                    : 4 states
treadmill               : 4 states
snoopy                  : 4 states
bird                    : 2 states


-----------------------------------------------
0 : empty bloc & broken bloc once broken & trapped block triggered & appear/disappear bloc not visible
1 : breakable bloc
2 : pushable block, not pushed
3 : trap block, not triggered yet
4 : block invincible, or block pushable already pushed
5 : block appear, visible
6 : treadmill block
7 : ball block
8 : snoopy block
9 : bird block

0 no direction
1 no direction
2 4 direction  NSWE
3 no direction
4 no direction
5 no direction
6 4 direction NSWE
7 4 SO, B=SE, C=NO, D=NE)
8 4 direction NSWE
9 2 direction EW (E=EAST, W=WEST)

as for the direction it

multi-value blocks :
concerning save/load/initalization :
some blocks can be stacked on top of each other wich will "create value" for the blocks :
    -the ball is able to move above everything in the map without exception
    -snoopy is able to position himself on top of certains blocks, but not all of them

in these cases, the object will be wrinten in txt files, next to eachother, to represent the fact that they are stacked on top of each other
each element separated by AT LEAST one space have different coordinates and are different objects

It wont be an int[][], but a String[][] use so we can add intel easier such as direction

all use case possible :
nominal:
0, 1, 2S, 2N, 2E, 2W, 3, 4, 5, 6S, 6N, 6E, 6W,7SO, 7SE, 7NO, 7NE, 8S, 8N, 8E, 8W,9E, 9W
ball on all case, for each direction
07SO, 07SE, 07NO, 07NE, 17SO, 17SE, 17NO, 17NE, 27SO, 27SE, 27NO, 27NE, 37SO, 37SE, 37NO, 37NE, 47SO, 47SE, 47NO, 47NE, 57SO, 57SE, 57NO, 57NE, 67SO, 67SE, 67NO, 67NE, 87SO, 87SE, 87NO, 87NE, 97SO, 97SE, 97NO, 97NE
snoopy on top of treadmill, for each direction
6N8S, 6N8N, 6N8W, 6N8E, 6S8S, 6S8N, 6S8W, 6S8E, 6E8S, 6E8N, 6E8W, 6E8E, 6W8S, 6W8N, 6W8W, 6W8E

snoopy cant be on a trap
snoopy can only be on a treadmill
ball cant be on snoopy
snoopy cant be on ball
snoopy cant be on bird

Ball on all theses
snoppy on top of : treadmill, trap

//
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 2N 0 2S 0 2W 0 2E 0 3 0 4 0 5 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 6N 0 6S 0 6W 0 6E 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9E 0 9W 0 0 0
0 0 0 0 7A 0 7B 0 7C 0 7D 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 8N 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 2N 0 2S 0 2W 0 2E 0 3 0 4 0 5 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 6N 0 6S 0 6W 0 6E 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9E 0 9W 0 0 0
0 0 0 0 7A 0 7B 0 7C 0 7D 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 8N 0 8S 0 8W 0 8E 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0