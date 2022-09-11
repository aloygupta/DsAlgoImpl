package endianness;

import java.nio.ByteOrder;

public class Endian {

    public static String getEndian(){
        return ByteOrder.nativeOrder().toString();
    }

    public static void main(String[] args){
        System.out.println(Endian.getEndian());
    }

    // C program

/*#include <stdio.h>
    int main()
    {
        unsigned int i = 1;
        char *c = (char*)&i;
        if (*c)
        printf("Little endian");
   else
        printf("Big endian");
        getchar();
        return 0;
    }*/
}
