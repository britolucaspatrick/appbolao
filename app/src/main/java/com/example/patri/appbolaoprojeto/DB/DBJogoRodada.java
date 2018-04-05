package com.example.patri.appbolaoprojeto.DB;

import android.support.annotation.NonNull;

import com.example.patri.appbolaoprojeto.Entity.JogoRodada;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DBJogoRodada {

    public static final List dbJogoRodada = new List<JogoRodada>() {

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<JogoRodada> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] ts) {
            return null;
        }

        @Override
        public boolean add(JogoRodada jogoRodada) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends JogoRodada> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull Collection<? extends JogoRodada> collection) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public JogoRodada get(int i) {
            return null;
        }

        @Override
        public JogoRodada set(int i, JogoRodada jogoRodada) {
            return null;
        }

        @Override
        public void add(int i, JogoRodada jogoRodada) {

        }

        @Override
        public JogoRodada remove(int i) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<JogoRodada> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<JogoRodada> listIterator(int i) {
            return null;
        }

        @NonNull
        @Override
        public List<JogoRodada> subList(int i, int i1) {
            return null;
        }
    };

}
