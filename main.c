#include <stdio.h>
#include<time.h>
#include <stdlib.h>
#include<math.h>

__asm void your_strcpy(const char *src, char *dst)
{
    loop
        LDRB r2, [r0] ; Load byte into r2 from mem. pointed to by r0 (src pointer)
        ADDS r0, #1 ; Increment src pointer

        STRB r2, [r1] ; Store byte in r2 into memory pointed to by (dst pointer)
        ADDS r1, #1 ; Increment dst pointer
        CMP r2, #0 ; Was the byte 0?
        BNE loop ; If not, repeat the loop
        BX lr ; Else return from subroutine
}
int main() {
    const char a[] = "Hello world!";
    char b[20];
    your_strcpy(a, b);
    // your_capitalize(b);
    while (1) ;
	return 1;
}

