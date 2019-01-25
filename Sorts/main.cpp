#include <iostream>
#include <ctime>

using namespace std;

void bubbleSort(int *a, int n)
{   unsigned int start_time =  clock();
    int temp;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (a[j] > a[j + 1])
            {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
         }
     }



    unsigned int end_time = clock();
    unsigned int runtime = end_time - start_time;
    cout << "The bubble sort completed in " << (double)runtime / CLOCKS_PER_SEC << " second" <<"\n";
}

void insertionSort(int *a, int n)
{

    unsigned int start_time =  clock();
    int tmp;
    for(int i = 1 ; i < n ; i++)
        for(int j = i ; j > 0 && a[j - 1] > a[j] ; j--)
        {
            tmp = a[j - 1];
            a[j-1] = a[j];
            a[j] = tmp;
       }



    unsigned int end_time = clock();
    unsigned int runtime = end_time - start_time;
    cout << "The insertion sort completed in " << (double)runtime / CLOCKS_PER_SEC << " second\n";

}

void quickSort(int *a, int n, int left, int right)//подаем на вход  массив, левую и правую границы массива
{
    int l = left;
    int r = right;
    cout <<"l = " << l << "  r=" <<r << endl;
    int m = a[(right + left) / 2];//Ищем середину массива
    cout <<"a[m]="<< a[m]<<" m = " << m;

    int temp = 0;//Вспомогательная переменная


    while(l<=r)//Сортируем половинки....
    {
        while (a[l] < m)
            l++;
        cout << endl<<"l= " << l<< endl;
        cout <<"a[l] after while=" <<a[l]<<endl;
        while (a[r] > m)
            r--;
        cout <<"r= " << r<< endl;
        cout <<"a[r] after while=" <<a[r]<<endl;
        if (l <= r)
        {
            temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }

         cout <<"a[l] after if=" <<a[l]<<endl;
         cout << endl<<"l= " << l<< endl;

         cout <<"a[r] after if=" <<a[r]<<endl;
         cout <<"r= " << r<< endl;

         for(int i = 0; i<8;i++)
             cout <<"On step "<< i+1 <<": "<< a[i]<< endl;


    }

    for(int i = 0; i<8;i++)
        cout <<"On step "<< i+1 <<": "<< a[i]<< endl;
    cout<< endl;
    //Рекурсивный проход по массиву
    if(l < right)
        quickSort(a, n , l, right);
    cout << "sort req left" <<  endl;
    if(left < r)
        quickSort(a, n, left, r);
}

int main()
{

    int randMass3[8] ={10, 6, 4, 3, 4, 1, 8, 12};
//    randMass3[0]=10;
//    randMass3[1]=6;
//    randMass3[2]=4;
//    randMass3[3]=3;
//    randMass3[4]=7;
//    randMass3[5]=1;
//    randMass3[6]=8;
//    randMass3[7]=12;


    //int *randMass1 = new int[n];
    //int *randMass2 = new int[n];
   // int randMass3 =[10, 6, 4,3,7,1,8,12];

    //for (int i = 0; i < n; i++)
    //{
      //  randMass1[i] = rand();
        //randMass2[i] = randMass1[i];
        //randMass3[i] = randMass1[i];

    //}
    //bubbleSort(randMass1,n);
    //cout << endl;

    //insertionSort(randMass2, n);
    //cout << endl;

     int n = 8;
    unsigned int start_time =  clock();
    quickSort(randMass3, n,0, n - 1);
    unsigned int end_time = clock();
    unsigned int runtime = end_time - start_time;
    cout << "The quick sort completed in " << (double)runtime / CLOCKS_PER_SEC << " second";
    cout << endl;
    for(int i = 0; i<8;i++)
        cout << randMass3[i];


    return 0;

}
