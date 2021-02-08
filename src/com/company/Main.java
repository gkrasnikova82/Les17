package com.company;

import java.util.Scanner;
/*
З 16 Расстановка скобокЗадание
Не выполнено: ДЗ 16 Расстановка скобок
Проверить правильность расстановок скобок в выражении, использующем скобки вида: “(”, “)”, “{”, “}”, “[”, “]”.
Требование вложенности скобок разного вида не учитывать, т.е., например, последовательности скобок “({})[]” и “([{()}]}”
 — правильные.
Скобки с консоли считывать одной строкой.

Примечание: используйте стек, реализованный в предыдущем уроке.
*/

class Link
{
    public long dData; // элемент данных
    public Link next; // следующая ссылка в списке
    // -------------------------------------------------------------
    public Link(long dd) // constructor
    { dData = dd; }
    // -------------------------------------------------------------
    public void displayLink() // display ourself
    { System.out.print(dData + " "); }
} // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
    private Link first; // ссылка на первый элемент в списке
    // -------------------------------------------------------------
    public LinkList() // constructor
    { first = null; } // пока элементов в списке нет
    // -------------------------------------------------------------
    public boolean isEmpty() // истина, если список пуст
    { return (first==null); }
    // -------------------------------------------------------------
    public void insertFirst(long dd) // вставляем в начало списка
    { // создать новую ссылку
        Link newLink = new Link(dd);
        newLink.next = first; // newLink --> сначала старые
        first = newLink; // сначала --> newLink
    }
    // -------------------------------------------------------------
    public long deleteFirst() // удаляем первый элемент
    { // (так как список сумм не пустой)
        Link temp = first; // согханяем ссылку на ссылку
        first = first.next; // удаляем первый - старый следующий
        return temp.dData; // возвращаем удаленную ссылку
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        Link current = first; // начать с начала списка
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
// -------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////
class LinkStack
{
    private LinkList theList;
    //--------------------------------------------------------------
    public LinkStack() // constructor
    {
        theList = new LinkList();
    }
    //--------------------------------------------------------------
    public void push(long j) // помещаем элемент поверх стека
    {
        theList.insertFirst(j);
    }


    //--------------------------------------------------------------
    public long pop() // берем элемент сверху стека
    {
        return theList.deleteFirst();
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // истина, если стек пуст
    {
        return ( theList.isEmpty() );
    }
    //--------------------------------------------------------------
    public void displayStack()
    {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
//--------------------------------------------------------------
} // end class LinkStack

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// режим ввода информации из консоля
        System.out.println("Введите последовательность скобок");

        String Doc = sc.next();
        LinkStack theStack = new LinkStack(); // make stack

        for(int i=0; i<Doc.length(); i++){//заполнение стека
            theStack.push(Doc.charAt(i));
        }

        System.out.println("Состояние стэка: ");
        theStack.displayStack();

        int result = 0; //результат проверки последовательности скобок
        long next;
        for(int i=0; theStack.isEmpty()==false; i++){ //проверка последовательности скобок
            next = theStack.pop();
            if (next == 40) {result = result+1;} // "("
            if (next == 41) {result = result-1;} //")"
            if (next == 91) {result = result+2;} // "["
            if (next == 93) {result = result-2;} // "]"
            if (next == 123) {result = result+3;} // "{"
            if (next == 125) {result = result-3;} // "}"
        }
        if (result == 0) {System.out.println("Последовательность скобок правильная");}
        else {System.out.println("Последовательность скобок НЕ правильная");}
    }
}


