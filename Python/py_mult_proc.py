import multiprocessing
from multiprocessing import Process, Queue


def func(q, i):
    print('子进程%s 开始put数据' % i)
    q.put('我是%s 通过Queue通信' % i)


if __name__ == '__main__':
    q = Queue()

    cu = multiprocessing.cpu_count()

    process_list = []
    for i in range(cu):
        p = Process(target=func, args=(q, i,))
        p.start()
        process_list.append(p)

    for i in process_list:
        p.join()

    for i in range(cu):
        print(q.get())
